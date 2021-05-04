package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

import static com.company.Sample.getMusicEntity;


public class Mp3ForIDV {
    public Mp3ForIDV(String s) {
    }

    public static void setMusicEntity(String path, MusicEntity v1Entity) {
        try {
            byte[] bufferAll = new byte[128];
            byte[] buffTag;
            byte[] buffTitleofSong = new byte[30];
            byte[] buffInterpreter = new byte[30];
            byte[] buffAlbum = new byte[30];
            byte[] buffYear = new byte[4];
            byte[] buffComment = new byte[30];
            byte[] buffGenre = new byte[1];
            byte[] buffFoot;

            buffTag = "TAG".getBytes();
            byte[] cache;
            if (v1Entity.getTitle_of_song() != null) {
                cache = v1Entity.getTitle_of_song().getBytes();
                System.arraycopy(cache, 0, buffTitleofSong, 0, cache.length);
            }

            if (v1Entity.getInterpreter() != null) {
                cache = v1Entity.getInterpreter().getBytes("GBK");
                System.arraycopy(cache, 0, buffInterpreter, 0, cache.length);
            }

            if (v1Entity.getAlbum() != null) {
                try {
                    cache = v1Entity.getAlbum().getBytes("GBK");
                    System.arraycopy(cache, 0, buffAlbum, 0, cache.length);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            if (v1Entity.getYear_of_publication() != null) {
                cache = v1Entity.getYear_of_publication().getBytes("GBK");
                System.arraycopy(cache, 0, buffYear, 0, cache.length);
            }

            if (v1Entity.getComment() != null) {
                cache = v1Entity.getComment().getBytes("GBK");
                int num = 28;
                if (cache.length <= num) {
                    num = cache.length;
                }
                System.arraycopy(cache, 0, buffComment, 0, num);
            }

            if (v1Entity.getGenre() != null) {
                cache = v1Entity.getGenre().getBytes("GBK");
                System.arraycopy(cache, 0, buffGenre, 0, cache.length);
            }
            buffFoot = "111".getBytes();

            System.arraycopy(buffTag, 0, bufferAll, 0, 3);
            System.arraycopy(buffTitleofSong, 0, bufferAll, 3, 30);
            System.arraycopy(buffInterpreter, 0, bufferAll, 33, 30);
            System.arraycopy(buffAlbum, 0, bufferAll, 63, 30);
            System.arraycopy(buffYear, 0, bufferAll, 93, 4);
            System.arraycopy(buffComment, 0, bufferAll, 97, 30);
            System.arraycopy(buffGenre, 0, bufferAll, 127, 1);
            System.arraycopy(buffFoot, 0, bufferAll, 125, 3);


            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(path), "rw");

            long len = randomAccessFile.length();
            if (getMusicEntity(path) != null) {
                //There's v1. We need to delete 128 from the back.
                len = randomAccessFile.length() - 128;
            }
            randomAccessFile.seek(len);
            randomAccessFile.write(bufferAll, 0, bufferAll.length);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
