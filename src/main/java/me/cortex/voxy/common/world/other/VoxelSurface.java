package me.cortex.voxy.common.world.other;

public final class VoxelSurface {
    public static final long Y_MASK = 15;
    public static final long VALID = 16;
    private static final long MASK = Y_MASK|VALID;

    private VoxelSurface() {}

    public static long withHeight(long mapping, int blockY) {
        return (mapping&~MASK)|VALID|(blockY&Y_MASK);
    }

    public static long packQuadHeight(long mapping, int lodLevel) {
        long levelMask = (1L<<lodLevel)-1;
        return (mapping&VALID)==0?0:Long.MIN_VALUE|((mapping&levelMask&Y_MASK)<<42);
    }
}
