package dev.miguel.service.impl;

import dev.miguel.model.LabSeq;
import dev.miguel.service.LabSeqService;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class LabSeqServiceImpl implements LabSeqService {

    private static final Map<Integer, Long> cache = new HashMap<>();

    @Override
    public LabSeq labSeq(Integer n) throws IllegalArgumentException {

        if (n < 0 || n > 100000) {
            throw new IllegalArgumentException("The value of n must be between 0 and 100000.");
        }

        LabSeq labSeq = new LabSeq();
        Long startTime = System.currentTimeMillis();

        cache.put(0, 0L);
        cache.put(1, 1L);
        cache.put(2, 0L);
        cache.put(3, 1L);

        for (int i = 4; i <= n; i++) {
            if (!cache.containsKey(i)) {
                Long value = cache.get(i - 4) + cache.get(i - 3);
                cache.put(i, value);
            }
        }

        List<Long> sequence = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            sequence.add(cache.get(i));
        }

        System.out.println(cache);

        Long endTime = System.currentTimeMillis();
        Long time = endTime - startTime;

        labSeq.setResult(cache.get(n));
        labSeq.setSequence(sequence);
        labSeq.setTime(time + "ms");

        return labSeq;
    }
}
