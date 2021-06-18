package com.ha.slidingwindow;

import java.io.Serializable;
import java.sql.Timestamp;

public interface ChronologicalRecord extends Serializable {
    Number getValue();
    Timestamp getTimestamp();
}
