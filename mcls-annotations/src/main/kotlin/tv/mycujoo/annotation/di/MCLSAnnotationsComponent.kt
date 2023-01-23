package tv.mycujoo.annotation.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import tv.mycujoo.annotation.annotation.IAnnotationView
import tv.mycujoo.annotation.mediator.AnnotationManager
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        MCLSAnnotationModule::class
    ]
)
interface MCLSAnnotationsComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindContext(context: Context): Builder

        @BindsInstance
        fun bindAnnotationView(annotationView: IAnnotationView): Builder

        fun create(): MCLSAnnotationsComponent
    }

    fun inject(annotationManager: AnnotationManager.Builder)
}
