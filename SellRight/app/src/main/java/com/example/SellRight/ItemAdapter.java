import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends BaseAdapter {

    private Context context;
    private List<ItemModel> itemList;
    private LayoutInflater inflater;

    public ItemAdapter(Context context, List<ItemModel> itemList) {
        this.context = context;
        this.itemList = itemList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_row, parent, false);
        }

        ImageView itemImage = convertView.findViewById(R.id.itemImage);
        TextView itemName = convertView.findViewById(R.id.itemName);
        TextView itemQty = convertView.findViewById(R.id.itemQty);
        TextView itemPrice = convertView.findViewById(R.id.itemPrice);

        ItemModel item = itemList.get(i);

        itemImage.setImageResource(item.getImage());
        itemName.setText(item.getName());
        itemQty.setText(item.getQuantity());
        itemPrice.setText("₵" + item.getPrice());

        return convertView;
    }
}
