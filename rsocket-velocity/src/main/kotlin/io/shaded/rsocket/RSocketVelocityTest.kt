package io.shaded.rsocket

import com.google.inject.Inject
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
import com.velocitypowered.api.plugin.Plugin
import com.velocitypowered.api.proxy.ProxyServer
import io.rsocket.RSocket
import io.rsocket.SocketAcceptor
import io.rsocket.core.RSocketServer
import io.rsocket.transport.netty.server.TcpServerTransport
import org.slf4j.Logger

@Plugin(
    id = "rsocket-proxy",
    name = "rsocket-proxy",
    version = "0.0.1-SNAPSHOT",
    authors = ["Aethonx"]
)
class RSocketVelocityTest @Inject constructor(
    val proxyServer: ProxyServer,
    val logger: Logger
) {


    @Subscribe
    fun onProxyInitialization(event: ProxyInitializeEvent) {
        this.logger.info("Starting RSocket test.")
        RSocketServer
            .create(SocketAcceptor.with(RSocketImpl()))
            .bind(TcpServerTransport.create(7000))
            .block()

    }

    class RSocketImpl : RSocket
}