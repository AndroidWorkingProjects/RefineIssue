package refineoptions.rahul.com.refineoptions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by dev3 on 25/4/16.
 */
public class RefineAdapter extends BaseAdapter {

    private Context context;
    private int layoutId;
    private ArrayList filterNamesList = new ArrayList();
    private ArrayList filterValuesList = new ArrayList();
    private LinkedHashMap<String, ArrayList<RefineSubListDto>> filterMap = new LinkedHashMap<>();
    LayoutInflater inflater;

    public RefineAdapter(Context context, int layoutId, ArrayList filterNamesList, LinkedHashMap filterMap) {
        this.context = context;
        this.layoutId = layoutId;
        this.filterNamesList = filterNamesList;
        this.filterMap = filterMap;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return filterNamesList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(layoutId, parent, false);
            holder = new ViewHolder();
            holder.header = (TextView) convertView.findViewById(R.id.heading);
            holder.listView = (ListView) convertView.findViewById(R.id.refine_sub_list);
            holder.editText = (EditText) convertView.findViewById(R.id.ed_to_refine);
            holder.imageView = (ImageView) convertView.findViewById(R.id.click_to_add);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.header.setText((CharSequence) filterNamesList.get(position));

        getProductsAdapter(position, holder.listView);
        return convertView;
    }

    class ViewHolder {
        TextView header;
        ListView listView;
        EditText editText;
        ImageView imageView;
    }

    public void getProductsAdapter(int position, ListView listFlow) {
        final ArrayList<RefineSubListDto> filterSubList = filterMap.get(filterNamesList.get(position));
        listFlow.setAdapter(new RefineSubAdapter(context, R.layout.refine_subadapter_listview, filterSubList));
        Utility.setListViewHeightBasedOnChildren(listFlow);
    }
}
