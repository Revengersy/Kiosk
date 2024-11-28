package challenge.lv2.refactored;

public interface Consolable {
    public String getItemsInformation(int index);

//    콘솔에 표시되는 기본 자료 카피
    public <T extends Consolable> T getBasicItem();

}
