package `in`.shantanupatil.sharecare.di

import `in`.shantanupatil.sharecare.modules.repository.LocalDataRepository
import `in`.shantanupatil.sharecare.modules.repository.FirebaseDataRepository
import `in`.shantanupatil.sharecare.modules.repository.interfaces.ILocalDataRepository
import `in`.shantanupatil.sharecare.modules.repository.interfaces.IFirebaseDataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRemoteDataRepository(): IFirebaseDataRepository = FirebaseDataRepository()

    @Provides
    fun provideLocalDataRepository(): ILocalDataRepository = LocalDataRepository()
}