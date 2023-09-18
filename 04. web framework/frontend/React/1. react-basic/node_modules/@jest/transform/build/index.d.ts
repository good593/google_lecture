/**
 * Copyright (c) Facebook, Inc. and its affiliates. All Rights Reserved.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
export { createScriptTransformer, createTranspilingRequire, } from '@jest/transform/build/ScriptTransformer';
export type { TransformerType as ScriptTransformer } from '@jest/transform/build/ScriptTransformer';
export { default as shouldInstrument } from '@jest/transform/build/shouldInstrument';
export type { CallerTransformOptions, Transformer, SyncTransformer, AsyncTransformer, ShouldInstrumentOptions, Options as TransformationOptions, TransformOptions, TransformResult, TransformedSource, } from '@jest/transform/build/types';
export { default as handlePotentialSyntaxError } from '@jest/transform/build/enhanceUnexpectedTokenMessage';
