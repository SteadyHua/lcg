package top.easelink.lcg.ui;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;
import javax.inject.Singleton;

import top.easelink.framework.utils.rx.SchedulerProvider;
import top.easelink.lcg.ui.main.article.viewmodel.ArticleViewModel;
import top.easelink.lcg.ui.main.article.viewmodel.DownloadLinkViewModel;
import top.easelink.lcg.ui.main.articles.viewmodel.ArticlesViewModel;
import top.easelink.lcg.ui.main.articles.viewmodel.FavoriteArticlesViewModel;
import top.easelink.lcg.ui.main.articles.viewmodel.ForumArticlesViewModel;
import top.easelink.lcg.ui.main.forumnav.viewmodel.ForumNavigationViewModel;
import top.easelink.lcg.ui.search.viewmodel.SearchViewModel;

@Singleton
public class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory {

    private SchedulerProvider schedulerProvider;

    @Inject
    public ViewModelProviderFactory(SchedulerProvider schedulerProvider) {
        this.schedulerProvider = schedulerProvider;
    }

    @Override
    @NonNull
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ArticlesViewModel.class)) {
            return (T) new ArticlesViewModel(schedulerProvider);
        } else if (modelClass.isAssignableFrom(ArticleViewModel.class)) {
            return (T) new ArticleViewModel(schedulerProvider);
        } else if (modelClass.isAssignableFrom(ForumArticlesViewModel.class)) {
            return (T) new ForumArticlesViewModel(schedulerProvider);
        } else if (modelClass.isAssignableFrom(SearchViewModel.class)) {
            return (T) new SearchViewModel(schedulerProvider);
        } else if (modelClass.isAssignableFrom(DownloadLinkViewModel.class)) {
            return (T) new DownloadLinkViewModel(schedulerProvider);
        } else if (modelClass.isAssignableFrom(FavoriteArticlesViewModel.class)) {
            return (T) new FavoriteArticlesViewModel(schedulerProvider);
        } else if (modelClass.isAssignableFrom(ForumNavigationViewModel.class)) {
            return (T) new ForumNavigationViewModel(schedulerProvider);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}