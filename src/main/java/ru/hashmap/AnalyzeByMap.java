package ru.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        Double sum = 0D;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
            }
        }
        return sum / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            Double sum = 0D;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            Double pupilAvg = sum / pupil.subjects().size();
            result.add(new Label(pupil.name(), pupilAvg));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Label> avgBySubjects = new LinkedHashMap();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                Double temp = 0D;
                if (avgBySubjects.containsKey(subject.name())) {
                    temp = avgBySubjects.get(subject.name()).score();
                }
                avgBySubjects.put(subject.name(), new Label(subject.name(),
                        temp + (double) subject.score() / pupils.size()));
            }
        }
        return avgBySubjects.values().stream().toList();
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> scoreByPupils = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            scoreByPupils.add(new Label(pupil.name(), sum));
        }
        scoreByPupils.sort(Comparator.naturalOrder());
        return scoreByPupils.get(scoreByPupils.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Label> sumScoresBySubjects = new LinkedHashMap();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                Double temp = 0D;
                if (sumScoresBySubjects.containsKey(subject.name())) {
                    temp = sumScoresBySubjects.get(subject.name()).score();
                }
                sumScoresBySubjects.put(subject.name(), new Label(subject.name(),
                        temp + subject.score()));
            }
        }

        List<Label> result = new ArrayList(sumScoresBySubjects.values().stream().toList());
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }
}
