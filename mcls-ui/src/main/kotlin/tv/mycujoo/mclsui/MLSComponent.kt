package tv.mycujoo.mclsui

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import tv.mycujoo.annotation.annotation.IAnnotationView
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        MlsModule::class
    ]
)
interface MLSComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindContext(context: Context): Builder

        @BindsInstance
        fun bindAnnotationView(annotationView: IAnnotationView): Builder

        fun create(): MLSComponent
    }

    fun inject(annotationView: AnnotationView)
    fun inject(annotationView: MLSAnnotationView)
}