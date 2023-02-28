package org.javacream.util;
    public class IdGenerator {
        private Long counter = 0l;
        public Long nextId(){
            return ++counter;
        }
    }
