package com.example.offline.comments;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.offline.rx.SchedulersFacade;

class CommentsViewModelFactory implements ViewModelProvider.Factory {

    private final GetCommentsUseCase getCommentsUseCase;
    private final AddCommentUseCase addCommentUseCase;
    private final SyncCommentUseCase syncCommentUseCase;
    private final SchedulersFacade schedulersFacade;

    CommentsViewModelFactory(GetCommentsUseCase getCommentsUseCase,
                             AddCommentUseCase addCommentUseCase,
                             SyncCommentUseCase syncCommentUseCase,
                             SchedulersFacade schedulersFacade) {
        this.getCommentsUseCase = getCommentsUseCase;
        this.addCommentUseCase = addCommentUseCase;
        this.syncCommentUseCase = syncCommentUseCase;
        this.schedulersFacade = schedulersFacade;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(CommentsViewModel.class)) {
            return (T) new CommentsViewModel(getCommentsUseCase, addCommentUseCase, syncCommentUseCase, schedulersFacade);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
