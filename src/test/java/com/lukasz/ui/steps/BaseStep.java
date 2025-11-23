package com.lukasz.ui.steps;

public abstract class BaseStep {
    protected BaseStep nextStep;

    public BaseStep then(BaseStep nextStep) {
        this.nextStep = nextStep;
        return nextStep;
    }

    public void act() {
        performAction();
        if (nextStep != null) {
            nextStep.act();
        }
    }

    protected abstract void performAction();
}
