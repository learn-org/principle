package com.learn.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author: lxj
 * @Date: 2021/8/4
 * @Description:
 */
@AllArgsConstructor
@Getter
public enum MeetingEmailTemplateEnum {
    /**
     * 会议信息变更通知邮件模板
     */
    MEETING_INFO_CHANGE_NOTIFY_EMAIL(1,"CUEOA-【会议信息更新】",
            "Hi，#{userName} <br/>以下标红字段为更新内容：<br/>",
            "<br/><font color=red><strong>主题：#{meetingSubject}</strong></font>",
            "<br/><font color=red><strong>会议时间：#{meetingTime}</strong></font>",
            "<br/><font color=red><strong>会议地点：#{meetingAddress}</strong></font>",
            "<br/><font color=red><strong>会议室：#{meetingRoom}</strong></font>",
            "<br/><font color=red><strong>预约人员：#{reserve}</strong></font>",
            "<br/><font color=red><strong>参会人员：#{attendees}</strong></font>",
            "<br/><br/>备注： 1.预约人可以在会议开始前15分钟至会议开始后15分钟之间，点击【开始会议】开启会议。\n" +
                    "<br/>2.如果预约人没有点击【开始会议】，会议将被自动取消，空出的时间段可提供其他人继续预约。\n" +
                    "<br/>3.一个月2次预约会议室后未使用会议室（未触发【开始会议】），会被视为违约状态，违约的员工本月剩余天数+次月将无法预约会议室。\n" +
                    "<br/><br/>该邮件为系统自动发出，请勿直接回复邮件。"),
    MEETING_INFO_CANCEL_EMAIL(2,"CUEOA-【会议取消】",
            "Hi，#{userName} <br/><br/>",
            "<br/><font color=red><strong>主题：#{meetingSubject}</strong></font>",
            "<br/><font color=red><strong>会议时间：#{meetingTime}</strong></font>",
            "<br/><font color=red><strong>会议地点：#{meetingAddress}</strong></font>",
            "<br/><font color=red><strong>会议室：#{meetingRoom}</strong></font>",
            "<br/><font color=red><strong>预约人员：#{reserve}</strong></font>",
            "<br/><font color=red><strong>参会人员：#{attendees}</strong></font>",
            "<br/><br/>备注： 1.预约人可以在会议开始前15分钟至会议开始后15分钟之间，点击【开始会议】开启会议。\n" +
                    "<br/>2.如果预约人没有点击【开始会议】，会议将被自动取消，空出的时间段可提供其他人继续预约。\n" +
                    "<br/>3.一个月2次预约会议室后未使用会议室（未触发【开始会议】），会被视为违约状态，违约的员工本月剩余天数+次月将无法预约会议室。\n" +
                    "<br/><br/>该邮件为系统自动发出，请勿直接回复邮件。");
    /**
     * 属性在类中的排序
     */
    private int sort;
    /**
     * 邮件主题
     */
    private String emailSubject;
    /**
     * 称谓
     */
    private String salutation;
    /**
     * 会议主题
     */
    private String meetingSubject;
    /**
     * 会议时间
     */
    private String meetingTime;
    /**
     * 会议地址
     */
    private String meetingAddress;
    /**
     * 会议室
     */
    private String meetingRoom;
    /**
     * 预约人员
     */
    private String reserve;
    /**
     * 参会人员
     */
    private String attendees;
    /**
     * 备注
     */
    private String remark;

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                    System.out.println(getEmailTemplate(getMeetingChangeInfo(), MeetingEmailTemplateEnum.MEETING_INFO_CANCEL_EMAIL));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
    private static Map<String, Boolean> getMeetingChangeInfo() {
        // 会议信息变更记录
        Map<String, Boolean> meetingChangeInfoMap = new LinkedHashMap<>();
        // 称谓
        meetingChangeInfoMap.put("salutation", Boolean.FALSE);
        // 会议主题
        meetingChangeInfoMap.put("meetingSubject", Boolean.FALSE);

        // 会议时间
        meetingChangeInfoMap.put("meetingTime", Boolean.TRUE);

        // 会议地址
        meetingChangeInfoMap.put("meetingAddress", Boolean.FALSE);

        // 会议室
        meetingChangeInfoMap.put("meetingRoom", Boolean.TRUE);
        // 预约人员
        meetingChangeInfoMap.put("reserve", Boolean.TRUE);
        // 参会人员
        meetingChangeInfoMap.put("attendees", Boolean.FALSE);
        meetingChangeInfoMap.put("remark", Boolean.FALSE);
        return meetingChangeInfoMap;
    }
    /**
     * 获取邮件模板
     * @param meetingChangeInfoMap
     * @return
     * @throws Exception
     */
    public static String getEmailTemplate (Map<String, Boolean> meetingChangeInfoMap, MeetingEmailTemplateEnum meetingEmailTemplateEnum) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        if (meetingChangeInfoMap != null) {
            Class clazz = MeetingEmailTemplateEnum.class;
            Object[] objects = clazz.getEnumConstants();
            for (Map.Entry<String, Boolean> entry : meetingChangeInfoMap.entrySet()) {
                Field f = clazz.getDeclaredField(entry.getKey());
                f.setAccessible(Boolean.TRUE);
                if (Objects.equals(f.getName(), entry.getKey())) {
                    // 获取属性值
                    Object value = f.get(objects[meetingEmailTemplateEnum.getSort() - 1]);
                    if (entry.getValue()) {
                        stringBuilder.append(value);
                    } else {
                        if (Objects.nonNull(value)) {
                            String result = (value + "").replaceAll("<font color=red><strong>", "")
                                    .replaceAll("</strong></font>", "");
                            stringBuilder.append(result);
                        }
                    }
                }
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 填充动态变量的值
     *
     * @param content
     * @param variableMap
     * @return
     */
    public static String fillVariable(String content, Map<String, Object> variableMap) {
        if (!StringUtils.isEmpty(content) && variableMap != null) {
            for (Map.Entry<String, Object> entry : variableMap.entrySet()) {
                content = content.replaceAll("\\#\\{" + entry.getKey() + "\\}", entry.getValue() + "");
            }
        }
        return content;
    }
}
