package com.example.databinding.store;


import com.example.databinding.model.Album;

import java.util.List;

public interface AlbumStore {
    Album get(long albumId);

    Album getByIndex(int position);

    List<Album> getAll();

    void save(Album album);

    void delete(Album album);

    void clear();
}
