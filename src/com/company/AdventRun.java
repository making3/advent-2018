package com.company;

public interface AdventRun<TInput> {
    String getRunName();
    TInput getInput();
    String run(TInput input);
}
