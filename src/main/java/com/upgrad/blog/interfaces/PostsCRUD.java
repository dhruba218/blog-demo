package com.upgrad.blog.interfaces;

import com.upgrad.blog.dto.PostDTO;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;

public interface PostsCRUD {

    /**
     *
     * @param emailId
     * @return
     * @throws SQLException
     */
    public List<PostDTO> findByEmail(String emailId) throws SQLException, ClassNotFoundException;

    /**
     *
     * @param postDTO
     * @return
     * @throws SQLException
     */
    public PostDTO create(PostDTO postDTO) throws SQLException, ClassNotFoundException;

    /**
     *
     * @param id
     * @param emailId
     * @return
     * @throws SQLException
     */
    public boolean deleteById(int id, String emailId) throws SQLException, ClassNotFoundException;

    /**
     *
     * @param tag
     * @return
     * @throws SQLException
     */
    public List<PostDTO> findByTag(String tag) throws SQLException, ClassNotFoundException;

    /**
     *
     * @return
     * @throws SQLException
     */
    public HashSet<String> findAllTags() throws SQLException, ClassNotFoundException;
}
