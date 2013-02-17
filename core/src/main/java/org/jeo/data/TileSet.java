package org.jeo.data;

import java.io.IOException;
import java.util.List;

/**
 * A layer consisting of {@link Tile} objects.
 * 
 * @author Justin Deoliveira, OpenGeo
 */
public interface TileSet extends Layer {

    /**
     * The immutable list of tile grids of the layer.
     * <p>
     * The list should be sorted ascending by {@link TileGrid#getZoom()}. 
     * </p>
     */
    List<TileGrid> grids();

    /**
     * The tile grid for the specific zoom level.
     */
    TileGrid grid(long z);

    /**
     * Reads a single tile from the layer by tile index.
     * 
     * @param z The zoom level of the tile.
     * @param x The column of the tile. 
     * @param y The row of the tile.
     * 
     * @return The tile at the specified index, or <code>null</code> if no such tile exists at the 
     * specified index.
     */
    Tile read(long z, long x, long y) throws IOException;

    /**
     * Reads a set of tiles from the layer.
     * <p>
     * Any of the arguments of this method may be <code>-1</code> to specify no constraint.
     * </p>
     * @param z1 The minimum zoom level.
     * @param z2 The maximum zoom level.
     * @param x1 The minimum column index.
     * @param x2 The maximum column index.
     * @param y1 The minimum row index.
     * @param y2 The maximum row index.
     * 
     * @return A cursor over the tile set.
     */
    Cursor<Tile> read(long z1, long z2, long x1, long x2, long y1, long y2) throws IOException;
}
