package com.company;

public class Sample {

    public static MusicEntity getMusicEntity(String path) {
        if (path == null) {
            return null;
        }
        return getMusicEntity(new File(path));
    }

    public static MusicEntity getMusicEntity(File musicFile) {
        if (musicFile == null) {
            return null;
        }
//        MusicEntity v1Entity;
//        try {
//            RandomAccessFile randomAccessFile = new RandomAccessFile(musicFile, "r");
//            byte[] buffer = new byte[128];
//            randomAccessFile.seek(randomAccessFile.length() - 128);
//            randomAccessFile.read(buffer);
//            if (buffer.length == 128) {
//                v1Entity = new MusicEntity();
//                String tag = new String(buffer, 0, 3);

//
//                if (tag.equalsIgnoreCase("TAG")) {
//
//                    v1Entity.setTitle_of_song(title_of_song);
//                    v1Entity.setArtist(artist);
//                    v1Entity.setAlbum(album);
//                    v1Entity.setYear(year);
//                    v1Entity.setComment(comment);
//
//
//                    return v1Entity;
//                } else {
//
//                    return null;
//                }
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

}

