package tv.mycujoo.mclscast.session

import com.google.android.gms.cast.framework.CastSession
import tv.mycujoo.mclscast.IRemoteMediaClient
import tv.mycujoo.mclscast.RemoteMediaClient

class CasterSession : ICasterSession {
    var castSession: CastSession? = null
    override fun getRemoteMediaClient(): IRemoteMediaClient? {
        castSession?.remoteMediaClient?.let {
            return RemoteMediaClient(it)
        }
        return null
    }
}