package org.javacream.util;

import org.springframework.stereotype.Service;

@Service
public class IdGenerator {
        private Long counter = 0l;
        public Long nextId(){
            return ++counter;
        }
    }
