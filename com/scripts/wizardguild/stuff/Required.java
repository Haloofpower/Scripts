package com.scripts.wizardguild.stuff;

import org.powerbot.script.Area;
import org.powerbot.script.Tile;

/**
 * Created by Jeremy on 11/3/2014.
 */
public class Required {

    public enum locations {
        YANILLE(new Area(
                new Tile(2615, 3071, 0),
                new Tile(2622, 3072, 0),
                new Tile(2628, 3089, 0),
                new Tile(2623, 3102, 0),
                new Tile(2615, 3113, 0),
                new Tile(2598, 3114, 0),
                new Tile(2569, 3114, 0),
                new Tile(2557, 3113, 0),
                new Tile(2539, 3113, 0),
                new Tile(2522, 3099, 0),
                new Tile(2525, 3085, 0),
                new Tile(2531, 3075, 0),
                new Tile(2543, 3068, 0),
                new Tile(2569, 3066, 0),
                new Tile(2603, 3067, 0),
                new Tile(2610, 3069, 0)),
                "Yanille"),
        WIZARD_GUILD(new Area(
                new Tile(2596, 3090, 0),
                new Tile(2593, 3094, 0),
                new Tile(2589, 3094, 0),
                new Tile(2584, 3089, 0),
                new Tile(2584, 3086, 0),
                new Tile(2589, 3081, 0),
                new Tile(2593, 3081, 0),
                new Tile(2597, 3086, 0)),
                "Wizard Guild"),
        WGUILD_ZOMBIES(new Area(
                new Tile(2590, 9483, 0),
                new Tile(2595, 9483, 0),
                new Tile(2595, 9494, 0),
                new Tile(2581, 9494, 0),
                new Tile(2581, 9496, 0),
                new Tile(2590, 9487, 0)),
                "Wizard's Guild Zombies");

        private locations(Area n, String name) {
            this.location = n;
            this.locationName = name;
        }

        public Area getLocation() {
            return location;
        }

        public String getName() {
            return locationName;
        }

        private Area location;
        private String locationName;
    }

    public enum paths {
        YANILLE(new Tile[] {
                new Tile(2872, 3437, 0),
                new Tile(2865, 3443, 0),
                new Tile(2865, 3450, 0),
                new Tile(2863, 3458, 0),
                new Tile(2854, 3471, 0),
                new Tile(2852, 3479, 0),
                new Tile(2857, 3496, 0),
                new Tile(2855, 3510, 0),
                new Tile(2839, 3509, 0),
                new Tile(2838, 3501, 0),
                new Tile(2840, 3492, 0),
                new Tile(2844, 3487, 0),
                new Tile(2847, 3478, 0),
                new Tile(2846, 3473, 0),
                new Tile(2843, 3468, 0),
                new Tile(2842, 3464, 0),
                new Tile(2846, 3460, 0),
                new Tile(2849, 3454, 0),
                new Tile(2851, 3446, 0),
                new Tile(2857, 3444, 0),
                new Tile(2853, 3439, 0),
                new Tile(2848, 3436, 0),
                new Tile(2840, 3434, 0),
                new Tile(2835, 3435, 0),
                new Tile(2827, 3438, 0),
                new Tile(2812, 3436, 0),
                new Tile(2809, 3434, 0),
                new Tile(2801, 3434, 0),
                new Tile(2798, 3434, 0),
                new Tile(2793, 3434, 0),
                new Tile(2784, 3431, 0),
                new Tile(2771, 3427, 0),
                new Tile(2760, 3424, 0),
                new Tile(2750, 3420, 0),
                new Tile(2737, 3412, 0),
                new Tile(2726, 3404, 0),
                new Tile(2718, 3398, 0),
                new Tile(2705, 3388, 0),
                new Tile(2688, 3380, 0),
                new Tile(2673, 3385, 0),
                new Tile(2659, 3391, 0),
                new Tile(2652, 3388, 0),
                new Tile(2646, 3378, 0),
                new Tile(2639, 3373, 0),
                new Tile(2636, 3370, 0),
                new Tile(2636, 3360, 0),
                new Tile(2637, 3348, 0),
                new Tile(2637, 3339, 0),
                new Tile(2628, 3333, 0),
                new Tile(2624, 3329, 0),
                new Tile(2623, 3297, 0),
                new Tile(2614, 3297, 0),
                new Tile(2609, 3297, 0),
                new Tile(2607, 3292, 0),
                new Tile(2606, 3285, 0),
                new Tile(2600, 3284, 0),
                new Tile(2597, 3282, 0),
                new Tile(2596, 3278, 0),
                new Tile(2596, 3276, 0),
                new Tile(2598, 3272, 0),
                new Tile(2599, 3268, 0),
                new Tile(2599, 3263, 0),
                new Tile(2596, 3257, 0),
                new Tile(2593, 3251, 0),
                new Tile(2601, 3245, 0),
                new Tile(2596, 3232, 0),
                new Tile(2586, 3224, 0),
                new Tile(2578, 3213, 0),
                new Tile(2570, 3204, 0),
                new Tile(2570, 3195, 0),
                new Tile(2576, 3186, 0),
                new Tile(2577, 3171, 0),
                new Tile(2575, 3156, 0),
                new Tile(2576, 3139, 0),
                new Tile(2582, 3132, 0),
                new Tile(2590, 3127, 0),
                new Tile(2603, 3125, 0),
                new Tile(2614, 3123, 0),
                new Tile(2618, 3115, 0),
                new Tile(2617, 3107, 0),
                new Tile(2611, 3103, 0),
                new Tile(2607, 3099, 0),
                new Tile(2603, 3093, 0),
                new Tile(2602, 3087, 0),
                new Tile(2597, 3087, 0)}, "Path to Yanille");

        private paths(Tile[] path, String name) {
            this.path = path;
            this.name = name;
        }

        public Tile[] getPath() {
            return path;
        }

        public String getName() {
            return name;
        }

        private Tile[] path;
        private String name;
    }
}
