/**
 * Copyright (c) Facebook, Inc. and its affiliates. All Rights Reserved.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
import getResultHeader from '@jest/reporters/build/getResultHeader';
export type { Config } from '@jest/types';
export type { AggregatedResult, SnapshotSummary, TestResult, } from '@jest/test-result';
export { default as BaseReporter } from '@jest/reporters/build/BaseReporter';
export { default as CoverageReporter } from '@jest/reporters/build/CoverageReporter';
export { default as DefaultReporter } from '@jest/reporters/build/DefaultReporter';
export { default as NotifyReporter } from '@jest/reporters/build/NotifyReporter';
export { default as SummaryReporter } from '@jest/reporters/build/SummaryReporter';
export { default as VerboseReporter } from '@jest/reporters/build/VerboseReporter';
export type { Context, Reporter, ReporterOnStartOptions, SummaryOptions, Test, } from '@jest/reporters/build/types';
export declare const utils: {
    formatTestPath: (config: import("@jest/types/build/Config").ProjectConfig | import("@jest/types/build/Config").GlobalConfig, testPath: string) => string;
    getResultHeader: typeof getResultHeader;
    getSummary: (aggregatedResults: import("@jest/test-result").AggregatedResult, options?: import("@jest/reporters/build/types").SummaryOptions | undefined) => string;
    printDisplayName: (config: import("@jest/types/build/Config").ProjectConfig) => string;
    relativePath: (config: import("@jest/types/build/Config").ProjectConfig | import("@jest/types/build/Config").GlobalConfig, testPath: string) => {
        basename: string;
        dirname: string;
    };
    trimAndFormatPath: (pad: number, config: import("@jest/types/build/Config").ProjectConfig | import("@jest/types/build/Config").GlobalConfig, testPath: string, columns: number) => string;
};
