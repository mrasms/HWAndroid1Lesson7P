package com.example.hwandroid1lesson7p.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hwandroid1lesson7p.R;
import com.example.hwandroid1lesson7p.adapter.AdapterOnBoard;
import com.example.hwandroid1lesson7p.databinding.ActivityOnBoardBinding;
import com.example.hwandroid1lesson7p.model.OnBoardModel;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class OnBoardActivity extends AppCompatActivity {
    private ActivityOnBoardBinding binding;
    private ArrayList<OnBoardModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnBoardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupData();
        listeners();
        setupDots();
    }

    private void setupData() {
        list.add(new OnBoardModel(R.drawable.wallet, "Кошелёк", "№1 сюда добавляю большое описание прям на много строк и как нибудь придумаю как выровнять его по центру"));
        list.add(new OnBoardModel(R.drawable.money_bag, "Мешок (предположительно с деньгами)", "№2 сюда добавляю большое описание прям на много строк и как нибудь придумаю как выровнять его по центру"));
        list.add(new OnBoardModel(R.drawable.piggy_bank, "Копилка", "№3 сюда добавляю большое описание прям на много строк и как нибудь придумаю как выровнять его по центру" +
                "Кстати! Этот текст можно прокрутить вниз / вверх, дальше напишу стих Маяковского про то как он кое-что достаёт из широких штанин " +
                "\n" + " С каким наслажденьем " +
                "жандармской кастой " +
                "я был бы " +
                "исхлестан и распят " +
                "за то, " +
                "что в руках у меня " +
                "молоткастый, " +
                "серпастый " +
                "советский паспорт. " +
                "Я волком бы " +
                "выгрыз " +
                "бюрократизм. " +
                "К мандатам " +
                "почтения нету. " +
                "К любым " +
                "чертям с матерями " +
                "катись " +
                "любая бумажка. " +
                "Но  эту… " +
                "Я " +
                "достаю " +
                "из широких штанин " +
                "дубликатом " +
                "бесценного груза. " +
                "Читайте, " +
                "завидуйте, " +
                "я —" +
                "гражданин " +
                "Советского Союза."));
        AdapterOnBoard adapterOnBoard = new AdapterOnBoard(getSupportFragmentManager(), getLifecycle(), list);
        binding.pager.setAdapter(adapterOnBoard);
    }

    private void listeners() {
        binding.pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position == list.size() - 1) {
                    binding.btnNext.setText("Start");
                } else binding.btnNext.setText("Next");
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.btnNext.getText() == "Start") {
                    Intent intent = new Intent(OnBoardActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else binding.pager.setCurrentItem(binding.pager.getCurrentItem() + 1);

            }
        });

        binding.btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OnBoardActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void setupDots() {
        TabLayout tabLayout = binding.tabLayout;
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, binding.pager, true, (tab, position) -> {
        });
        tabLayoutMediator.attach();
    }
}