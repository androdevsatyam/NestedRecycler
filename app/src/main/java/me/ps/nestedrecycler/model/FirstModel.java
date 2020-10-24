package me.ps.nestedrecycler.model;

import java.util.List;

public class FirstModel {

    List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public class Category {

        public String id, title, type;
        public List<ImageData> items;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<ImageData> getItems() {
            return items;
        }

        public void setItems(List<ImageData> items) {
            this.items = items;
        }
    }

    public class ImageData {
        public String title, icon, category;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }
    }

}
