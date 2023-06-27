package com.example.seoulpublicwifi.dao;

import com.example.seoulpublicwifi.common.Db;
import com.example.seoulpublicwifi.dto.HistoryDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistoryDao {
    public void insert(HistoryDto historyDto) {
        try {
            Class.forName(Db.CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DriverManager.getConnection(Db.URL);

            String sql = "INSERT INTO HISTORY (LNT, LAT, SEARCH_DTTM) VALUES (?, ?, datetime('now', 'localtime'));";

            ps = conn.prepareStatement(sql);
            ps.setDouble(1, historyDto.getLnt());
            ps.setDouble(2, historyDto.getLat());

            int affected = ps.executeUpdate();
            if (affected > 0) {
                System.out.println("히스토리 데이터 삽입 성공");
            } else {
                System.out.println("히스토리 데이터 삽입 실패");
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

            String sql = "DELETE FROM HISTORY WHERE ID = ?;";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            int affected = ps.executeUpdate();
            if (affected > 0) {
                System.out.println("히스토리 데이터 삭제 성공");
            } else {
                System.out.println("히스토리 데이터 삭제 실패");
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
            throw new RuntimeException(e);
        }

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(Db.URL);

            String sql = "SELECT COUNT(*) FROM HISTORY;";

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return count;
    }

    public List<HistoryDto> selectList() {
        List<HistoryDto> historyDtoList = new ArrayList<>();

        try {
            Class.forName(Db.CLASS);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(Db.URL);

            String sql = "SELECT * FROM HISTORY ORDER BY ID DESC";

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                double lnt = rs.getDouble("LNT");
                double lat = rs.getDouble("LAT");
                Date srcDttm = rs.getDate("SEARCH_DTTM");

                HistoryDto historyDto = new HistoryDto();
                historyDto.setId(id);
                historyDto.setLnt(lnt);
                historyDto.setLat(lat);
                historyDto.setSrcDttm(srcDttm);

                historyDtoList.add(historyDto);
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
        return historyDtoList;
    }
}
