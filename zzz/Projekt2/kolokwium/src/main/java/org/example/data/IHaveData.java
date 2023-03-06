package org.example.data;

import java.util.List;

public interface IHaveData <TItem extends IHaveDescription>{
    List<TItem> getData();

    void showData();
}
