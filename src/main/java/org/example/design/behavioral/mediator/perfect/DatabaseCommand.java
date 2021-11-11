package org.example.design.behavioral.mediator.perfect;

import lombok.Getter;
import lombok.Setter;
import org.example.design.behavioral.mediator.complete.DatabaseType;

import java.util.Map;

/**
 * Author: GL
 * Date: 2021-11-11
 */
public abstract class DatabaseCommand<T> {
    @Getter
    @Setter
    protected T data;

    public abstract void execute(Map<DatabaseType, AbstractDatabase<T>> dataMap);
}
