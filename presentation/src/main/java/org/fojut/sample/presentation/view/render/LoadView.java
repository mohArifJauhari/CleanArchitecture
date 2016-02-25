package org.fojut.sample.presentation.view.render;

/**
 * Interface representing a view that will use to load data.
 */
public interface LoadView {

    /**
     * Show a view with a progress bar indicating a loading process.
     */
    void showLoading();

    /**
     * Hide a loading view.
     */
    void hideLoading();

    /**
     * Show an error message
     *
     * @param message A string representing an error.
     */
    void showError(String message);
}
