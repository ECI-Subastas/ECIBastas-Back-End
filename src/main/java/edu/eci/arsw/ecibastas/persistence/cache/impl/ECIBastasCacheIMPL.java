package edu.eci.arsw.ecibastas.persistence.cache.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.ecibastas.model.Subasta;
import edu.eci.arsw.ecibastas.persistence.cache.ECIBastasCache;

@Repository
public class ECIBastasCacheIMPL implements ECIBastasCache {
    public static final String KEY = "auctions";

    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, Long, Subasta> hashOperations;

    @Autowired
	public ECIBastasCacheIMPL(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

    @PostConstruct
	private void intializeHashOperations() {
		hashOperations = redisTemplate.opsForHash();
	}

    @Override
    public List<Subasta> getAllAuctions() throws Exception {
        try {
            return hashOperations.values(KEY);
        } catch (Exception e) {
            throw new Exception(e.toString());
        }
    }

    @Override
    public void deleteAuction(int auctionId) throws Exception {
        try {
            hashOperations.delete(KEY,(long) auctionId);
        } catch (Exception e) {
            throw new Exception(e.toString());
        }
    }

    @Override
    public void putAuction(Subasta auction) throws Exception {
        try {
            hashOperations.put(KEY, (long) auction.getSubastaId(), auction);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
