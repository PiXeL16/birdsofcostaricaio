package com.greenpixels.birdsofcostarica.events;

import com.squareup.otto.Bus;

/**
 * Otto Bus Provider
 *
 * @author PiXeL16
 * @date 5/26/15
 */
public final class BusProvider {

    private static Bus bus;

    public static Bus getInstance()
    {
        if(bus == null)
        {
            bus = new Bus();
        }
        return bus;
    }

    private BusProvider() {
        // No instances.
    }
}
