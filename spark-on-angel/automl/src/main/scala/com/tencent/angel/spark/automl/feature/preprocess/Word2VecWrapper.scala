/*
 * Tencent is pleased to support the open source community by making Angel available.
 *
 * Copyright (C) 2017-2018 THL A29 Limited, a Tencent company. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 * https://opensource.org/licenses/Apache-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 */


package com.tencent.angel.spark.automl.feature.preprocess

import com.tencent.angel.spark.automl.feature.InToOutRelation.{InToOutRelation, OneToOne}
import com.tencent.angel.spark.automl.feature.TransformerWrapper
import org.apache.spark.ml.feature.Word2Vec

class Word2VecWrapper extends TransformerWrapper {

  override val transformer = new Word2Vec()
  override var parent: TransformerWrapper = _

  override val requiredInputCols: Array[String] = Array("sentences")
  override val requiredOutputCols: Array[String] = Array("outWord2Vec")

  override val hasMultiInputs: Boolean = false
  override val hasMultiOutputs: Boolean = false
  override val needAncestorInputs: Boolean = false

  override val relation: InToOutRelation = OneToOne

  override def declareInAndOut(): this.type = {
    transformer.setInputCol(getInputCols(0))
    transformer.setOutputCol(getOutputCols(0))
    this
  }
}
