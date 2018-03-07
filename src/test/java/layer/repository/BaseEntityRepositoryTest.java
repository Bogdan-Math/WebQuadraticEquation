package layer.repository;

import org.junit.Test;
import redis.embedded.RedisServer;

public class BaseEntityRepositoryTest {

    @Test
    public void name() throws Exception {
        RedisServer redisServer = new RedisServer();
        redisServer.start();

        redisServer.stop();
    }
}