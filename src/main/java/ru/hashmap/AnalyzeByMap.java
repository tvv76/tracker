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

    private static Map<String, Double> sumScoresBySubjects(List<Pupil> pupils) {
        Map<String, Double> result = new LinkedHashMap();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                Double temp = 0D;
                if (result.containsKey(subject.name())) {
                    temp = result.get(subject.name());
                }
                result.put(subject.name(), temp + (double) subject.score());
            }
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Double> avgBySubjects = sumScoresBySubjects(pupils);
        List<Label> resul = new ArrayList<>();

        List<Label> result = new ArrayList();
        for (String subject : avgBySubjects.keySet()) {
            Double score = avgBySubjects.get(subject);
            result.add(new Label(subject, score / pupils.size()));
        }
        return result;
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
        Map<String, Double> sumScoresBySubjects = sumScoresBySubjects(pupils);
        List<Label> scoresBySubjects = new ArrayList();

        for (String subject : sumScoresBySubjects.keySet()) {
            Double score = sumScoresBySubjects.get(subject);
            scoresBySubjects.add(new Label(subject, score));
        }

        scoresBySubjects.sort(Comparator.naturalOrder());
        return scoresBySubjects.get(scoresBySubjects.size() - 1);
    }
}
