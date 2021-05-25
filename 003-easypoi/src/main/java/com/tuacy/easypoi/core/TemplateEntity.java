package com.tuacy.easypoi.core;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/24 15:08.
 */
public class TemplateEntity {

    /**
     * 模板类型（当前单元格是显示测点值，还是测点名称之类的）
     */
    private TemplateTypeEnum type;
    /**
     * 根据TemplateTypeEnum的不同，对象也不同
     */
    private Object object;

    public TemplateEntity(TemplateTypeEnum type, Object object) {
        this.type = type;
        this.object = object;
    }

    public TemplateTypeEnum getType() {
        return type;
    }

    public void setType(TemplateTypeEnum type) {
        this.type = type;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "TemplateEntity{" +
                ", type=" + type +
                ", object=" + object +
                '}';
    }

    /**
     * 单元格显示测点对应的值
     *
     * @see TemplateTypeEnum
     */
    public static class TemplatePointValueEntity {

        /**
         * ioServerId
         */
        @JsonProperty("is")
        private String ioServerId;
        /**
         * pointId
         */
        @JsonProperty("pt")
        private String pointId;
        /**
         * 开始时间
         */
        @JsonProperty("st")
        private String startTime;
        /**
         * 结束时间
         */
        @JsonProperty("et")
        private String endTime;
        /**
         * 取值类型
         */
        @JsonProperty("vt")
        private int valueType;

        public String getIoServerId() {
            return ioServerId;
        }

        public void setIoServerId(String ioServerId) {
            this.ioServerId = ioServerId;
        }

        public String getPointId() {
            return pointId;
        }

        public void setPointId(String pointId) {
            this.pointId = pointId;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public int getValueType() {
            return valueType;
        }

        public void setValueType(int valueType) {
            this.valueType = valueType;
        }

        @Override
        public String toString() {
            return "TemplatePointValueEntity{" +
                    "ioServerId='" + ioServerId + '\'' +
                    ", pointId='" + pointId + '\'' +
                    ", startTime='" + startTime + '\'' +
                    ", endTime='" + endTime + '\'' +
                    ", valueType=" + valueType +
                    '}';
        }
    }

    /**
     * 单元格显示测点对应的名称
     *
     * @see TemplateTypeEnum
     */
    public static class TemplatePointNameEntity {
        /**
         * ioServer id
         */
        @JsonProperty("is")
        private String ioServerId;
        /**
         * point id
         */
        @JsonProperty("pt")
        private String pointId;

        public String getIoServerId() {
            return ioServerId;
        }

        public void setIoServerId(String ioServerId) {
            this.ioServerId = ioServerId;
        }

        public String getPointId() {
            return pointId;
        }

        public void setPointId(String pointId) {
            this.pointId = pointId;
        }

        @Override
        public String toString() {
            return "TemplatePointNameEntity{" +
                    "ioServerId='" + ioServerId + '\'' +
                    ", pointId='" + pointId + '\'' +
                    '}';
        }
    }

    /**
     * 单元格显示监控设备对应的名称
     *
     * @see TemplateTypeEnum
     */
    public static class TemplateMonitorDeviceNameEntity {
        /**
         * 监控设备对应的名字
         */
        @JsonProperty("mdi")
        private String monitorDeviceId;

        public String getMonitorDeviceId() {
            return monitorDeviceId;
        }

        public void setMonitorDeviceId(String monitorDeviceId) {
            this.monitorDeviceId = monitorDeviceId;
        }
    }

    /**
     * 单元格显示时间
     *
     * @see TemplateTypeEnum
     */
    public static class TemplateTimeEntity {
        /**
         * 时间值，例如：2021-05-25
         */
        @JsonProperty("tv")
        private String timeValue;
        /**
         * 时间格式化字符串，例如 yyyy年mm月
         */
        @JsonProperty("tf")
        private String timeFormatter;

        public String getTimeValue() {
            return timeValue;
        }

        public void setTimeValue(String timeValue) {
            this.timeValue = timeValue;
        }

        public String getTimeFormatter() {
            return timeFormatter;
        }

        public void setTimeFormatter(String timeFormatter) {
            this.timeFormatter = timeFormatter;
        }

        @Override
        public String toString() {
            return "TemplateTimeEntity{" +
                    "timeValue='" + timeValue + '\'' +
                    ", timeFormatter='" + timeFormatter + '\'' +
                    '}';
        }
    }

}
