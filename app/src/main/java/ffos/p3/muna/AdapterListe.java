package ffos.p3.muna;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterListe extends RecyclerView.Adapter<AdapterListe.Red> {

    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private List<Info> data;

    public AdapterListe(Context context) {
        this.mInflater = LayoutInflater.from(context);
        data = new ArrayList<>();
    }

    @Override
    public Red onCreateViewHolder(ViewGroup roditelj, int viewType) {
        View view = mInflater.inflate(R.layout.red_liste, roditelj, false);
        return new Red(view);
    }

    @Override
    public void onBindViewHolder(Red red, int position) {
        Info i = data.get(position);

        if (i.getState() != null) {
            red.result.setVisibility(View.VISIBLE);
            red.resultTitle.setVisibility(View.VISIBLE);
            red.result.setText(i.getState());
        } else {
            red.result.setVisibility(View.GONE);
            red.resultTitle.setVisibility(View.GONE);
        }

        if (i.getTime() != null) {
            red.date.setVisibility(View.VISIBLE);
            red.dateTitle.setVisibility(View.VISIBLE);
            red.date.setText(i.getTime());
        } else {
            red.date.setVisibility(View.GONE);
            red.dateTitle.setVisibility(View.GONE);
        }

        if (i.getValue() != null) {
            red.value.setVisibility(View.VISIBLE);
            red.valueTitle.setVisibility(View.VISIBLE);
            red.value.setText(i.getValue());
        } else {
            red.value.setVisibility(View.GONE);
            red.valueTitle.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return data==null ? 0 : data.size();
    }

    public class Red extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView result;
        private TextView value;
        private TextView date;
        private TextView valueTitle;
        private TextView dateTitle;
        private TextView resultTitle;
        Red(View itemView) {
            super(itemView);
            result = itemView.findViewById(R.id.resultData);
            value = itemView.findViewById(R.id.valueData);
            date = itemView.findViewById(R.id.dateData);
            resultTitle = itemView.findViewById(R.id.result);
            valueTitle = itemView.findViewById(R.id.value);
            dateTitle = itemView.findViewById(R.id.date);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    public Info getItem(int id) {
        return data.get(id);
    }

    public void setPodaci(List<Info> itemList) {
        this.data = itemList;
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
