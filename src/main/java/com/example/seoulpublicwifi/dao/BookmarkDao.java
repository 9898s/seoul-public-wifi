package com.example.seoulpublicwifi.dao;

import com.example.seoulpublicwifi.common.Db;
import com.example.seoulpublicwifi.dto.BookmarkDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookmarkDao {
    public void upsert(BookmarkDto bookmarkDto) {
        try {
            Class.forName(Db.CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DriverManager.getConnection(Db.URL);

            String sql = "INSERT OR REPLACE INTO BOOKMARK (GROUP_ID, MGR_NO, REGISTER_DTTM) VALUES (?, ?, datetime('now', 'localtime'));";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, bookmarkDto.getGId());
            ps.setString(2, bookmarkDto.getMgrNo());

            int affected = ps.executeUpdate();
            if (affected > 0) {
                System.out.println("북마크 데이터 삽입 성공");
            } else {
                System.out.println("북마크 데이터 삽입 실패");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public BookmarkDto select(int id) {
        BookmarkDto bookmarkDto = new BookmarkDto();

        try {
            Class.forName(Db.CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(Db.URL);

            String sql = "SELECT * FROM BOOKMARK WHERE ID = ?;";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {
                int id2 = rs.getInt("ID");
                int gid = rs.getInt("GROUP_ID");
                String mgrNo = rs.getString("MGR_NO");
                Date regDttm = rs.getDate("REGISTER_DTTM");

                bookmarkDto.setId(id2);
                bookmarkDto.setGId(gid);
                bookmarkDto.setMgrNo(mgrNo);
                bookmarkDto.setRegDttm(regDttm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return bookmarkDto;
    }

    public void delete(int id) {
        try {
            Class.forName(Db.CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DriverManager.getConnection(Db.URL);

            String sql = "DELETE FROM BOOKMARK WHERE ID = ?;";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            int affected = ps.executeUpdate();
            if (affected > 0) {
                System.out.println("북마크 데이터 삭제 성공");
            } else {
                System.out.println("북마크 데이터 삭제 실패");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public int count() {
        int count = 0;

        try {
            Class.forName(Db.CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(Db.URL);

            String sql = "SELECT COUNT(*) FROM BOOKMARK;";

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    public List<BookmarkDto> selectList() {
        List<BookmarkDto> bookmarkDtoList = new ArrayList<>();

        try {
            Class.forName(Db.CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(Db.URL);

            String sql = "SELECT BOOKMARK.* " +
                    "FROM BOOKMARK " +
                    "INNER JOIN BOOKMARK_GROUP " +
                    "ON BOOKMARK.GROUP_ID = BOOKMARK_GROUP.ID " +
                    "ORDER BY BOOKMARK_GROUP.SEQUENCE";

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                int gId = rs.getInt("GROUP_ID");
                String mgrNo = rs.getString("MGR_NO");
                Date regDttm = rs.getDate("REGISTER_DTTM");

                BookmarkDto bookmarkDto = new BookmarkDto();
                bookmarkDto.setId(id);
                bookmarkDto.setGId(gId);
                bookmarkDto.setMgrNo(mgrNo);
                bookmarkDto.setRegDttm(regDttm);

                bookmarkDtoList.add(bookmarkDto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return bookmarkDtoList;
    }
}
