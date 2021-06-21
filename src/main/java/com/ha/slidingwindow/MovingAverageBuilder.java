package com.ha.slidingwindow;

public class MovingAverageBuilder  {

    public static TypeParamBuilder newBuilder(){
        return new Steps();
    }

    public interface TypeParamBuilder {
        TimeFrameParamBuilder chronological();
    }

    public interface TimeFrameParamBuilder {
        ChronologicalBuilder withTimeFrame(long milliseconds);
        ChronologicalBuilder withMonth(int i);
        ChronologicalBuilder withMinutes(int i);
    }

    public interface ChronologicalBuilder {
        <E extends ChronologicalRecord> MovingAverage<E> build();
    }

    private static class Steps implements TypeParamBuilder, TimeFrameParamBuilder, ChronologicalBuilder {

        private Long timeFrame;

        @Override
        public TimeFrameParamBuilder chronological() {
            return this;
        }

        @Override
        public ChronologicalBuilder withTimeFrame(long milliseconds) {
            this.timeFrame = milliseconds;
            return this;
        }

        @Override
        public ChronologicalBuilder withMonth(int months) {
            this.timeFrame = months * 30 * 24 * 60 * 60 * 1000L;
            return this;
        }

        @Override
        public ChronologicalBuilder withMinutes(int minutes) {
            this.timeFrame = minutes * 60 * 1000L;
            return this;
        }

        @Override
        public <E extends ChronologicalRecord> MovingAverage<E> build() {
            return new ChronologicalMovingAverage<>(timeFrame);
        }
    }
}