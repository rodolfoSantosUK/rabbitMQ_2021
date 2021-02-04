package com.course.rabbitmqconsumertwo.entity;

public class DummyMessages {

    private String content;
    private int publishOrder;

    public DummyMessages(String content, int publishOrder) {
        this.content = content;
        this.publishOrder = publishOrder;
    }

    @Override
    public String toString() {
        return "DummyMessages{" +
                "content='" + content + '\'' +
                ", publishOrder=" + publishOrder +
                '}';
    }

    public DummyMessages( ) {

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPublishOrder() {
        return publishOrder;
    }

    public void setPublishOrder(int publishOrder) {
        this.publishOrder = publishOrder;
    }
}
