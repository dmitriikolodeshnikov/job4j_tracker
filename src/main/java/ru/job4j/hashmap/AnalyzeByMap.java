package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double score = 0D;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
                count++;
            }
        }
        return score / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();

        for (Pupil pupil : pupils) {
            double averageScore = 0D;
            int sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                averageScore = sum / pupil.subjects().size();
            }

            list.add(new Label(pupil.name(), averageScore));
        }
        return list;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        Map<String, Integer> mapSubjects = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int sum = mapSubjects.getOrDefault(subject.name(), 0);
                mapSubjects.put(subject.name(), sum + subject.score());
            }
        }
        for (String subjectName : mapSubjects.keySet()) {
            int score = mapSubjects.get(subjectName);
            list.add(new Label(subjectName, score / pupils.size()));
        }
        return list;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int score = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            list.add(new Label(pupil.name(), score));
        }
        list.sort(Comparator.naturalOrder());

        return list.get(list.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        Map<String, Integer> mapSubjects = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int sum = mapSubjects.getOrDefault(subject.name(), 0);
                mapSubjects.put(subject.name(), sum + subject.score());
            }
        }
        for (String subjectName : mapSubjects.keySet()) {
            int score = mapSubjects.get(subjectName);
            list.add(new Label(subjectName, score));
        }
        list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }
}