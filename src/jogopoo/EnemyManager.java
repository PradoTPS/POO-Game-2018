package jogopoo;

import java.util.ArrayList;

public class EnemyManager{
    private ArrayList<Spider> spiders = new ArrayList<Spider>();
    private int spawnCount = 0;
    private int spawnDelay = 80;

    public void onUpdate(GameManager gameManager){
        if(spawnCount <= 0){
            Spider spider = new Spider();
            spiders.add(spider);
            gameManager.instantiate(spider,100 + (180 * selectColumn()), 600);

            spawnCount = spawnDelay;

            spawnDelay = Util.clamp(spawnDelay - 2, 30, spawnDelay);
        }

        spawnCount--;

        viewCollisions(gameManager);
    }

    private void viewCollisions(GameManager gameManager){
        for(Bullet bullet : gameManager.bullets){
            for(int i = 0; i < spiders.size(); i++){
                if(bullet.isColliding(spiders.get(i).getBoundingBox())){
                    gameManager.destroy(spiders.get(i));
                    spiders.remove(spiders.get(i));
                }
            }
        }
    }

    private int selectColumn(){
        return Util.randomRange(0,3);
    }
}
