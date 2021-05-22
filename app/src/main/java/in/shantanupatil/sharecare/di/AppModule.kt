package `in`.shantanupatil.sharecare.di

import `in`.shantanupatil.sharecare.modules.repository.LocalDataRepository
import `in`.shantanupatil.sharecare.modules.repository.FirebaseDataRepository
import `in`.shantanupatil.sharecare.modules.repository.interfaces.ILocalDataRepository
import `in`.shantanupatil.sharecare.modules.repository.interfaces.IFirebaseDataRepository
import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideGlideInstance(
        @ApplicationContext context: Context
    ) = Glide.with(context)
        .setDefaultRequestOptions(
            RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
        )

    @Provides
    fun provideRemoteDataRepository(): IFirebaseDataRepository = FirebaseDataRepository()

    @Provides
    fun provideLocalDataRepository(): ILocalDataRepository = LocalDataRepository()
}