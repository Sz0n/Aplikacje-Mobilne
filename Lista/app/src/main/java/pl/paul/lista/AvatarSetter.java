package pl.paul.lista;

import android.widget.ImageView;

public class AvatarSetter {
    private ImageView avatar;

    public AvatarSetter(ImageView avatar) {
        this.avatar = avatar;
    }

    public void setImage() {
                avatar.setImageResource(R.drawable.iksde);
        }
}

