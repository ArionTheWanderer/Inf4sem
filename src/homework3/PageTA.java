package homework3;

public class PageTA implements Page {
    private String page;
    private int position;

    PageTA(String page) {
        this.page = page;
        position = 0;
    }

    @Override
    public String getPage() {
        return page;
    }

    @Override
    public void setPage(String page) {
        this.page = page;
    }

    @Override
    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public void goToAdv() {
        String text = Site.getInstance().getTextOnPosition(page, position);
        if (text != null) {
            page = text;
        }
    }
}
