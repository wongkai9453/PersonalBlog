package com.system.bean;

import java.util.Date;

public class Filemd {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column file_md.fileid
     *
     * @mbg.generated Mon May 11 16:23:20 GMT+08:00 2020
     */
    private String fileid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column file_md.user_id
     *
     * @mbg.generated Mon May 11 16:23:20 GMT+08:00 2020
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column file_md.filename
     *
     * @mbg.generated Mon May 11 16:23:20 GMT+08:00 2020
     */
    private String filename;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column file_md.filepath
     *
     * @mbg.generated Mon May 11 16:23:20 GMT+08:00 2020
     */
    private String filepath;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column file_md.filecontent
     *
     * @mbg.generated Mon May 11 16:23:20 GMT+08:00 2020
     */
    private String filecontent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column file_md.createtime
     *
     * @mbg.generated Mon May 11 16:23:20 GMT+08:00 2020
     */
    private Date createtime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_md.fileid
     *
     * @return the value of file_md.fileid
     *
     * @mbg.generated Mon May 11 16:23:20 GMT+08:00 2020
     */
    public String getFileid() {
        return fileid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_md.fileid
     *
     * @param fileid the value for file_md.fileid
     *
     * @mbg.generated Mon May 11 16:23:20 GMT+08:00 2020
     */
    public void setFileid(String fileid) {
        this.fileid = fileid == null ? null : fileid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_md.user_id
     *
     * @return the value of file_md.user_id
     *
     * @mbg.generated Mon May 11 16:23:20 GMT+08:00 2020
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_md.user_id
     *
     * @param userId the value for file_md.user_id
     *
     * @mbg.generated Mon May 11 16:23:20 GMT+08:00 2020
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_md.filename
     *
     * @return the value of file_md.filename
     *
     * @mbg.generated Mon May 11 16:23:20 GMT+08:00 2020
     */
    public String getFilename() {
        return filename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_md.filename
     *
     * @param filename the value for file_md.filename
     *
     * @mbg.generated Mon May 11 16:23:20 GMT+08:00 2020
     */
    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_md.filepath
     *
     * @return the value of file_md.filepath
     *
     * @mbg.generated Mon May 11 16:23:20 GMT+08:00 2020
     */
    public String getFilepath() {
        return filepath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_md.filepath
     *
     * @param filepath the value for file_md.filepath
     *
     * @mbg.generated Mon May 11 16:23:20 GMT+08:00 2020
     */
    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_md.filecontent
     *
     * @return the value of file_md.filecontent
     *
     * @mbg.generated Mon May 11 16:23:20 GMT+08:00 2020
     */
    public String getFilecontent() {
        return filecontent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_md.filecontent
     *
     * @param filecontent the value for file_md.filecontent
     *
     * @mbg.generated Mon May 11 16:23:20 GMT+08:00 2020
     */
    public void setFilecontent(String filecontent) {
        this.filecontent = filecontent == null ? null : filecontent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_md.createtime
     *
     * @return the value of file_md.createtime
     *
     * @mbg.generated Mon May 11 16:23:20 GMT+08:00 2020
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_md.createtime
     *
     * @param createtime the value for file_md.createtime
     *
     * @mbg.generated Mon May 11 16:23:20 GMT+08:00 2020
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}