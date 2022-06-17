package ms.builder;

public class Main {
    public static void main(String[] args) {
        TerrainBuilder builder = new ComplexTerrainBuilder();
        Terrain t = builder.buildFort(new Fort(10,10,50,50))
                .buildWall(new Wall(10,10,50,50))
                .buildMine(new Mine(10,10,50,50))
                .build();

        System.out.println(t);
    }
}
