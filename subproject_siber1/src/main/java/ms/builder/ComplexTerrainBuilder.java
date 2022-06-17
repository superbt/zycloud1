package ms.builder;

public class ComplexTerrainBuilder implements TerrainBuilder {

    Terrain terrain = new Terrain() ;

    @Override
    public TerrainBuilder buildWall(Wall my) {
        terrain.w = my ;
        return this;
    }

    @Override
    public TerrainBuilder buildFort(Fort mf) {
        terrain.f = mf;
        return this;
    }

    @Override
    public TerrainBuilder buildMine(Mine mm) {
        terrain.m = mm;
        return this;
    }

    @Override
    public Terrain build() {
        return terrain;
    }
}
