package ir.hosseinabbasi.data.common

import java.net.NetworkInterface
import java.util.*

/**
 * Created by Dr.jacky on 11/6/2018.
 */
class NetworkUtils {

    companion object {

        /**
         * Get Ip address of teh user
         *
         * @param useIPv4 a boolean to indicate take IPv4 or IPv6
         */
        fun getIpAddress(useIPv4: Boolean = true): String {
            try {
                val interfaces = Collections.list(NetworkInterface.getNetworkInterfaces())
                for (intf in interfaces) {
                    val addrs = Collections.list(intf.inetAddresses)
                    for (addr in addrs) {
                        if (!addr.isLoopbackAddress) {
                            val sAddr = addr.hostAddress
                            val isIPv4 = sAddr.indexOf(':') < 0
                            if (useIPv4) {
                                if (isIPv4)
                                    return sAddr
                            } else {
                                if (!isIPv4) {
                                    val delim = sAddr.indexOf('%')
                                    return if (delim < 0) sAddr.toUpperCase() else sAddr.substring(
                                        0,
                                        delim
                                    ).toUpperCase()
                                }
                            }
                        }
                    }
                }
            } catch (ex: Exception) {
            }
            return ""
        }
    }
}