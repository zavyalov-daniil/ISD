package Asonov.Zavialov.Kiselev;

import java.util.List;

public interface INote {
    public void setNoteName(String newNoteName);
    public String getNoteName(String noteName);

    /*Предполагается, что каждый абзац текста представлен отдельным экземпляром String*/
    public void setText(List<String> text);
    public List<String> getText();

    public void setTextFragment(List<String> text, int paragraph);
    public List<String> getTextFragment(int firstParagraph, int lastParagraph);

    public void loadMedia();//Команда для подгрузки из бд медиа-файлов. Предполагаю, что они не загружаются в оперативную память вместе с остальной заметкой.

    public List<Object> getTagsList();
    public void addTag(Object newTag);
    public void deleteTag(Object newTag);//Удаление с помощью переопределённого equal
    public void deleteTag(String tagName);//Удаление через поиск тега по названию

    /* Не уверен, что это необходимо
    Данные по типу Дата создания/изменения, etc
    public Object getMeta();
    public void setMeta();
    */
}
